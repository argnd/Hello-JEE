    var canvas = this.document.getElementById("aquariumCanvas");
    var processing = new Processing(canvas, function(processing) {
        processing.size(400, 400);
        processing.background(0xFFF);

        with (processing) {


            /**all creatures will have a lifeSpan and a hunger
             * lifeSpan will be fixes at creature creation and decrease over time
             * if lifeSpan < 0 creature = dead
             *
             * huger will define if the creature is attracted to its food type. if hunger < certain value lifespan =0; hunger decrease over time and is refilled when the creature will eat
             *
             * ////////////////////////CREATURES//////////////////////////
             *
             * Fishes (vectors)--> fishes always swim in one direction (chosen randomly at start) and bounce at borders until starving = true, point at  which they are attracted to their food and go eat it.
             FISHFOOD is in the bottom right corner, they may hoover it and eat it while simply walking. they can reproduce under certain condition.
             *
             *
             * SQUIDS (force & vector) --> attracted to you but they flee you aswell. random when mouse out of screen (enhanced stalker), grow in size and mass at  each new generation. each generation reduce squid living time. attracted to each other, vector walker at gen 1 & 5. stream.
             *
             * SMALLFISH (force and vector) --> Feed on squid,reppeled from Fishes. small live time, hunger fast deplete
             *
             * WORMS (ociliation) -->  wigly doodly wormy ASCII. use thetha and I for an ociliation wave. see worm constructor for more information. worm does not interact with other creatures.
             *
             Will add particles later, consider animaltsT1 as particles as they have basicaly the same behavior.
             **/

            var Test  = [1,2];

            var lifeState=0; //useless

            var G = 1;

            var sCount=0; //squidCount
            var sGen=0; //squidGen

            var fCount=0; //FishCount
            var fMated=0;

            var sfCount = 0; // SmallFish count

            var CreaturesT1 = function(){
                this.isDead= false;
                this.starving = false;
                this.lifeSpan = 813;
                this.hunger = 144;
            };

            CreaturesT1.prototype.isCreatureDead = function(creaLivedTime){
                return this.lifeSpan-creaLivedTime;
            };

            CreaturesT1.prototype.isCreatureStarving = function(creaAccumulatedHunger){
                return this.hunger-creaAccumulatedHunger;
            };

            CreaturesT1.prototype.creatureDeadEffect = function(crea, creaLivedTime){
                if (crea.isCreatureDead(creaLivedTime)<=0) {
                    this.isDead = true;
                } else {this.isDead = false;}

                if (crea.isCreatureDead(creaLivedTime)<=100){
                    this.mating = true;
                } else {
                    this.mating = false; }
            };

            CreaturesT1.prototype.creatureStarvingEffect = function(crea, creaAccumulatedHunger){
                if (crea.isCreatureStarving(creaAccumulatedHunger)<=0) {
                    this.starving = true;} else {
                    this.starving = false;
                }
                if (crea.isCreatureStarving(creaAccumulatedHunger)<=-180){
                    this.isDead = true;}
            };

            CreaturesT1.prototype.bounce = function(){

                if (this.pos.x < 0 || this.pos.x > width){
                    this.velocity.x = -this.velocity.x;
                    this.acceleration.x = -this.acceleration.x;
                }
                if (this.pos.y < 0 || this.pos.y > height){
                    this.velocity.y = -this.velocity.y;
                    this.acceleration.y = -this.acceleration.y;
                }

                if (this.pos.x <-5 || this.pos.x > width +5){
                    this.pos.x =200;
                }
                if (this.pos.y <-5 || this.pos.y > width +5){
                    this.pos.y = 200;
                }
            };

            CreaturesT1.prototype.applyForce = function(force) {
                var f = PVector.div(force, this.mass);
                this.acceleration.add(f);
            };

            CreaturesT1.prototype.calculateRepulsion = function(m) {
                var force = PVector.sub(this.pos, m.pos);
                var distance = force.mag();
                distance = constrain(distance, 5.0, 25.0);
                force.normalize();
                var strength = -(G * this.mass * m.mass) / (distance * distance);
                force.mult(strength);
                return force;
            };

            CreaturesT1.prototype.calculateAtraction = function(m) {
                var force = PVector.sub(this.pos, m.pos);
                var distance = force.mag();
                distance = constrain(distance, 5.0, 25.0);
                force.normalize();
                var strength = (G * this.mass * m.mass) / (distance * distance);
                force.mult(strength);
                return force;
            };

            /*CreaturesT1.prototype.stream = function(){
                var noisex = map(noise(this.pos.x,this.pos.y),0,1,-2,2);
                var noisey = map(noise(this.pos.x/3,this.pos.y/3),0,1,-2,2);
                var stream = new PVector(noisex,noisey);
                return stream;

            };
            */

            var Btn = function(x,y){
                this.x=x;
                this.y=y;

                this.underMouse=false;
            };

            Btn.prototype.isUnderMouse = function(x, y){
                return x<this.x+50 && x>this.x &&
                    y<this.y+25 && y>this.y;
            };

            Btn.prototype.display = function(){
                fill(186, 54, 85,130);
                rect(this.x,this.y,30,30,10);
            };

//////////////////////////////////////////////////////////

            var Fish = function(c, c1, c2, rate, test, isDead, starving, lifeSpan, hunger){
                CreaturesT1.call(this, isDead, starving, lifeSpan, hunger);
                this.mating =  false;
                this.mated = false;

                this.pos = new PVector(random(100,300),random(100,300));
                this.acceleration = new PVector(0,0) ;
                this.velocity = new PVector(random(-5,5),random(-5,5));
                this.rotate=0;

                this.mass = 40;

                this.creatureLivedTime = 0;
                this.accumulatedHunger = 0;

                //colors, used in display
                this.c = c;
                this.c1 = c1;
                this.c2 = c2;

                //individual random stuff
                this.rate=rate;
                this.test=test;

            };

            Fish.prototype = Object.create(CreaturesT1.prototype);

            Fish.prototype.display = function(){
                var hb = 340 - this.accumulatedHunger;
                hb = map(hb,0,340,0,50);
                var lb = 900 - this.creatureLivedTime;
                lb = map(lb,0,900,0,50);
                pushMatrix();
                translate(this.pos.x,this.pos.y);
                rotate(this.rotate);
                noStroke();
                fill(this.c, this.c1, this.c2);
                ellipse(0,0,30,15);
                triangle(-15,0,-40,10,-40,-10);
                fill(0, 0, 0);
                ellipse(10, 0, 5,5);
                fill(0, 0, 0,80);
                rect(-40,10,hb,10,80); //Hungerbar
                fill(13, 125, 0,80);//lifeBar
                rect(-40,-20,lb,10,80);
                popMatrix();
            };

            Fish.prototype.update = function(rate, posx, posy){

                var dir = PVector.sub(new PVector(posx,posy),new PVector(this.pos.x, this.pos.y));
                dir.normalize();

                this.creatureLivedTime+=this.rate/3;
                this.accumulatedHunger+=this.rate;

                if (this.starving === false){
                    this.rotate = this.velocity.heading();
                    this.pos.add(this.velocity);
                    this.velocity.add(this.acceleration);
                    this.velocity.limit(5);
                    this.acceleration.mult(0);
                } else if (this.starving === true){
                    this.acceleration = dir;
                    this.rotate = this.velocity.heading();
                    this.pos.add(this.velocity);
                    this.velocity.add(this.acceleration);
                    this.velocity.limit(8);}
                this.acceleration.mult(0);
            };

            Fish.prototype.eatFood = function(x, y){
                if (this.pos.x>x && this.pos.x < x + 30 &&
                    this.pos.y>y && this.pos.y < y + 30 ){
                    this.accumulatedHunger = 0;
                }
            };


            var Squid = function (c,c1,c2,rate,gen, isDead, lifeSpan) {

                CreaturesT1.call(this, isDead, lifeSpan);
                this.pos = new PVector(random(50,350),random(50,350));
                this.acceleration = new PVector(0,0);
                this.velocity = new PVector(0,0);
                this.rotate=0;

                this.mass=10 + sGen;

                this.creatureLivedTime = 0;


                //colors used in display
                this.c=c;
                this.c1=c1;
                this.c2=c2;

                this.rate=rate;

            };

            Squid.prototype = Object.create(CreaturesT1.prototype);

            Squid.prototype.display = function(sgen){
                pushMatrix();
                translate(this.pos.x,this.pos.y);
                rotate(this.rotate);
                noStroke();
                fill(this.c, this.c1, this.c2,125);
                ellipse(0,0,2*sgen + 5,2*sgen + 5);
                stroke(2);
                line(0,0,sgen + 5,sgen +5);
                popMatrix();
            };

            Squid.prototype.update = function(rate){

                var dir = PVector.sub(new PVector(mouseX,mouseY),new PVector(this.pos.x, this.pos.y));
                dir.normalize();

                var dir2 = PVector.sub(new PVector(this.pos.x,this.pos.y), new PVector(mouseX,mouseY));
                dir2.normalize();


                if ((mouseX>35 && mouseX < width-35) && (mouseY>35 && mouseY<height-35)){
                    if (Math.abs(this.pos.x-mouseX)< 15 || Math.abs(this.pos.y-mouseY)< 15 ){
                        this.acceleration=dir2;
                        this.rotate = -this.velocity.heading();
                        this.pos.add(this.velocity);
                        this.velocity.add(this.acceleration);
                        this.velocity.limit(4);
                        this.creatureLivedTime+=rate;
                        this.acceleration.mult(0);
                    }
                    this.acceleration=dir;
                    this.rotate = -this.velocity.heading();
                    this.pos.add(this.velocity);
                    this.velocity.add(this.acceleration);
                    this.velocity.limit(3);
                    this.creatureLivedTime+=rate;
                    this.acceleration.mult(0);
                }

                if (sGen===0 || sGen === 5){
                    this.acceleration.add(new PVector(random(-1,1),random(-1,1)));
                    this.rotate = -this.velocity.heading();
                    this.pos.add(this.velocity);
                    this.velocity.add(this.acceleration);
                    this.velocity.limit(3);
                    this.creatureLivedTime+=rate;
                    this.acceleration.mult(0);
                } else{
                    this.rotate = -this.velocity.heading();
                    this.pos.add(this.velocity);
                    this.velocity.add(this.acceleration);
                    this.velocity.limit(3);
                    this.creatureLivedTime+=rate;
                    this.acceleration.mult(0);
                }


            };


            var SmallFish = function ( isDead, starving, lifeSpan, hunger){
                CreaturesT1.call(this, isDead, starving, lifeSpan, hunger);

                this.rotate=0;
                this.accumulatedHunger = 0;
                this.creatureLivedTime = 0;

                this.mass = 5;
                this.pos = new PVector(random(100,300),random(100,300));
                this.velocity = new PVector(random(-1,1),random(-1,1));
                this.acceleration = new PVector(0,0);
            };

            SmallFish.prototype = Object.create(CreaturesT1.prototype);

            SmallFish.prototype.eatSquid = function(x, y,array, line){
                if (this.pos.x>x && this.pos.x < x+15 &&
                    this.pos.y>y && this.pos.y < y+15  && sGen !==5){
                    this.accumulatedHunger = 0;
                    sCount++;
                    array.splice(line,1);
                }
            };

            SmallFish.prototype.display = function(){
                pushMatrix();
                translate(this.pos.x,this.pos.y);
                rotate(this.rotate);
                noStroke();
                fill(255, 149, 0);
                ellipse(0,0,15,7.5);
                triangle(-7.5,0,-20,5,-20,-5);
                fill(0, 0, 0);
                ellipse(5,0,2.5,2.5);
                popMatrix();
            };

            SmallFish.prototype.update = function(rate,x,y){
                var dir = PVector.sub(new PVector(x,y),new PVector(this.pos.x, this.pos.y));
                dir.normalize();

                this.creatureLivedTime+=rate;
                this.accumulatedHunger+=rate/1.5;

                if (this.starving === false){
                    this.rotate = this.velocity.heading();
                    this.pos.add(this.velocity);
                    this.velocity.add(this.acceleration);
                    this.velocity.limit(5);
                    this.acceleration.mult(0);
                } else if (this.starving === true && sGen !== 5){
                    this.acceleration = dir;
                    this.rotate = this.velocity.heading();
                    this.pos.add(this.velocity);
                    this.velocity.add(this.acceleration);
                    this.velocity.limit(8);
                    this.acceleration.mult(0);}
                else if (this.starving === true && sGen === 5){
                    this.rotate = this.velocity.heading();
                    this.pos.add(this.velocity);
                    this.velocity.add(this.acceleration);
                    this.velocity.limit(8);
                    this.acceleration.mult(0);}
            };

            var Worm = function(){ //having fun with the dirty secret of strings aka memory killer. (well some will argue JS is the memory killer).
                this.pos = new PVector(200,200);
                this.velocity = new PVector(random(-1,1),random(-1,1));
                this.phrase = "##~~~~<>";
                this.theta = 0;
            };

            Worm.prototype.go = function(){
                this.display();
                this.update();
                this.bounce();

            };

            Worm.prototype.display = function(){
                pushMatrix();
                translate(this.pos.x,this.pos.y);
                rotate(this.velocity.heading());
                for (var c = 0; c<this.phrase.length;c++){
                    text(this.phrase[c], 5 * c * Math.abs(sin(this.theta) * 2), 5*c * cos(this.theta * 2 * c)/10 );
                }
                popMatrix();
            };

            Worm.prototype.update =  function(){
                this.pos.add(this.velocity);
                this.theta+=0.1;

            };

            Worm.prototype.bounce = function(){

                if (this.pos.x < 10 || this.pos.x > width-10){
                    this.velocity.x = -this.velocity.x;
                }
                if (this.pos.y < 10 || this.pos.y > height-10){
                    this.velocity.y = -this.velocity.y;
                }
            };


            var Food = function(x, y){
                this.pos = new PVector(x, y);
            };

            Food.prototype.fishfood = function(){ //display fishfood
                fill(219, 134, 31);
                stroke(0, 255, 247);
                rect(this.pos.x,this.pos.y,15,15);
            };

            Food.prototype.isBeingEaten = function(x, y){
                return x<this.x+15 && x>this.x &&
                    y<this.y+15 && y>this.y;
            };


//////////////////////////////////////////////////////////////



//FISHES
            var f = [];
            var fcreate = function(){
                for(var i = 0; f.length < 5; i++){
                    //c1, c2, c3, rate, test
                    f.push(new Fish(random(255),random(255), random(255),random(0.5,2),round(random(1))));
                }
            };
            var fremove = function(whatToBaseYourCheckOn, kThValueOfArray){
                if(whatToBaseYourCheckOn.isDead === true && f.length>0){
                    f.splice(kThValueOfArray,1);
                    fCount++;
                }
            };


//SMALLFISH
            var sf = [];
            var sfcreate = function(){
                for(var i = 0; sf.length < 10; i++){
                    sf.push(new SmallFish());
                }
            };
            var sfremove = function(whatToBaseYourCheckOn, kThValueOfArray){
                if(whatToBaseYourCheckOn.isDead === true && sf.length>0){
                    sf.splice(kThValueOfArray,1);
                    sfCount++;
                }
            };


//SQUIDS
            var s = [];
            var screate = function(){
                for(var c = 0; s.length < 15; c++){
                    s.push(new Squid(random(255),random(255),random(255),random(0.5,2),sGen));
                }
            };
            var sremove = function(whatToBaseYourCheckOn, kThValueOfArray){
                if(whatToBaseYourCheckOn.isDead === true && s.length){
                    s.splice(kThValueOfArray,1);
                    sCount++;
                }
            };


//FOODS
            var ff= new Food(width/2,(7/8)*height); //fishfood
            var ff2 = new Food(width/2,(1/8)*height); //fishfood2


//Btns
            var b=new Btn(0,0);

//Worms
            var w = new Worm();

//////////////////////////////////////////////////////////


            var displayFish1 = function(){
                fcreate();
                for (var i =0;i<f.length;i++){

                    if (f[i].test === 1){ //eatFood
                        f[i].update((i+1)/2, ff.pos.x, ff.pos.y);
                        f[i].eatFood(ff.pos.x, ff.pos.y);
                    } else {
                        f[i].update((i+1)/2, ff2.pos.x, ff2.pos.y);
                        f[i].eatFood(ff2.pos.x, ff2.pos.y);}


                    for (var j = 0; j<f.length; j++){ // mating
                        if (i!==j){
                            if (f[j].mating === true && f[j].mated === false && dist(f[j].pos.x,f[j].pos.y,f[i].pos.x,f[i].pos.y)<50) {
                                f.push(new Fish(f[j].c,f[j].c1, random(255),random(0.5,2),f[j].test)); //take some parent spec
                                f[j].mated = true;
                                fMated++;
                            }
                        }
                    }


                    f[i].bounce();
                    f[i].creatureDeadEffect(f[i],f[i].creatureLivedTime);
                    f[i].creatureStarvingEffect(f[i], f[i].accumulatedHunger);
                    f[i].display(30 * i,30*i-40,30*i +50);
                    fremove(f[i], i);
                }
            };


            var displaySquids1 = function(){
                screate();
                for (var i = 0; i < s.length;i++){
                    for(var j = 0; j<s.length;j++){
                        if(j !== i){
                            var attraction = s[j].calculateAtraction(s[i]);
                            s[i].applyForce(attraction);
                        }
                    }

                    /*var str = s[i].stream(); //stream
                    s[i].applyForce(str);*/

                    s[i].update(random(0.1,2)+sGen/3);
                    s[i].bounce();
                    s[i].creatureDeadEffect(s[i], s[i].creatureLivedTime);
                    s[i].display(sGen);
                    sremove(s[i], i);
                }
                sGen = constrain(floor(sCount/50),0,5);
            };


            var displaySF1 = function(){
                sfcreate();
                for (var i = 0; i < sf.length;i++){
                    sf[i].creatureDeadEffect(sf[i], sf[i].creatureLivedTime);
                    sf[i].creatureStarvingEffect(sf[i], sf[i].accumulatedHunger);


                    for (var j =0; j < f.length; j++){
                        var repulsion =f[j].calculateRepulsion(sf[i]);
                        sf[i].applyForce(repulsion);
                    }

                    for (var j =0; j<s.length; j++){
                        sf[i].eatSquid(s[j].pos.x, s[j].pos.y,s,j);
                    }
                    sf[i].update((i+1)/3,s[i].pos.x,s[i].pos.y);
                    sf[i].bounce();
                    sf[i].display(24*i,24*i,24*i);
                    sfremove(sf[i], i);
                }
            };

            var displayFood1 = function(){
                ff.fishfood();
                ff2.fishfood();
            };

            var draw= function() {
                background(0, 105, 196);
                displayFish1();
                displayFood1();
                displaySquids1();
                displaySF1();
                w.go();


                fill(0, 242, 255);
                text("SquidGen is " + sGen + ". nextGen every 50 Squids. Dead squids : " + sCount, 10,10);
                text("so far " + fCount + " Fish have died",10,20);
                text("so far " + fMated + " Fish have reproduced",10,30);
                text("so far " + sfCount + " SmallFish have died",10,40);
            };


//Easter egg
            mouseDragged = function(){
                if (b.isUnderMouse(mouseX,mouseY)){
                    text("Why not Zoidberg", random(0,width-100),random(0,height-100));
                    text("Much Doge", random(0,width-100),random(0,height-100));
                    text("Many WOW", random(0,width-100),random(0,height-100));
                }
            };

        }
        if (typeof draw !== 'undefined') processing.draw = draw;
    });