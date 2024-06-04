public class User {
    private String nom;
    private String email;
    private String password;
    private String adresse;
    private String tel ;

    public User(String nom, String email, String adresse, String tel,String password) {
        this.nom = nom;
        this.email = email;
        this.adresse = adresse;
        this.tel = tel;
        this.password = password;

    }
    @Override
    public String toString() {
        return String.format("User{nom='%s', email='%s', adresse='%s', tel='%s,password='%s'}",
                nom, email, adresse, tel,password);
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTel() {
        return tel;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


}
