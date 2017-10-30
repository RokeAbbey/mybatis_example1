package roles.elements;

public enum SexPartner {
    Lou("lou"), LouLou("loulou"), LouLouLou("louloulou");

    private String realname;

    SexPartner(String name){
        this.realname = name;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public static void main(String[] args){
        System.out.println(SexPartner.Lou.getRealname());
    }
}
