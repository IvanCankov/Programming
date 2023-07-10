zpublic class myStarCollection implements StarCollection{

    private Mobile root;
    public myStarCollection(Mobile m){
        root = m;
    }
    @Override
    public boolean contains(Star s) {
        if(this.root instanceof BalancedStick){
           return ((BalancedStick)this.root).contains(s);
        } else {
            return this.root.equals(s);
        }
    }
}
