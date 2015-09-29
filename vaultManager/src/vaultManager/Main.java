package vaultManager;

public class Main {

    public static void main(String[] args) {
	dbDriver db = new dbDriver();
	db.initDatabase("prueba", "dawan.ddns.net:3306", "test", "test");
    }

}
