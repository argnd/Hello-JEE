function showChosenIdProduct() {
    let val = 'http://localhost:8080/Hello_JavaEE_war_exploded/auth/showproduct?ID=' + this.document.getElementById("maValeur").value;
    return val;
}