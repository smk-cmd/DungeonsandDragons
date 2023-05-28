public abstract class Enemy extends Entity
{
    /* Constructs an enemy with a given name and health by using the super class
     * @param n The enemy's name
     * @param mHp The enemy's max health
     */
    public Enemy(String n, int mHp)
    {
        super(n, mHp);
    }
}
