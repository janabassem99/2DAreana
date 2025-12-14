abstract public class Fighter {

    private String name;
    private int health;
    private int maxHp;
    private double speed;
    protected double xPosition, yPosition;
    protected boolean facingRight;
    protected Shape fighterShape;
    private Color fighterColor;
    private List<Weapon> weapons = new ArrayList<>();
    private int currentWeaponIndex = 0;
    protected long lastShoot;

    public Fighter() {
    }

    public Fighter(String name, int health, double x, double y, double speed, boolean facingRight, long lastShoot, Color color, int maxHp) {
        this.name = name;
        this.health = health;
        this.xPosition = x;
        this.yPosition = y;
        this.speed = speed;
        this.facingRight = facingRight;
        this.lastShoot = lastShoot;
        this.fighterColor = color;
        this.fighterShape = null;
        this.maxHp = maxHp;
    }

    public abstract void createShape();

    public double getX() {
        return xPosition;
    }

    public double getY() {
        return yPosition;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }

}