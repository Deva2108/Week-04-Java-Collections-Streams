class Cup<T> {
    T drink;
    void fill(T drink) {
        this.drink = drink;
    }
    T sip() {
        return drink;
    }
}
