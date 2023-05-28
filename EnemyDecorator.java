public abstract class EnemyDecorator extends Enemy
{
    private Enemy enemy;

    /* Decorates a preexisting enemy with class titles and buffs
     * @param e The enemy object being decorated
     * @param n The adjusted name of the enemy
     * @param h The amount of health being added to the enemy's max hp
     */
    public EnemyDecorator(Enemy e, String n, int h)
    {
        super(n, h);
        enemy = e;
    }

    /* Overrides the super class and returns a description of the attack
     * @param e The entity that is being attacked
     * @return A description of the enemy's attack
     */
    public String attack(Entity e)
    {
        return enemy.attack(e);
    }
}
