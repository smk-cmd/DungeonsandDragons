public interface Magical
{
    /* This is the menu of the different spells an entity can cast
     */
    static final String MAGIC_MENU = "1. Magic Missile\n2. Fireball\n3. Thunderclap";

    /* Allows the implementing entity to use the Magic Missile attack
     * @param e The entity that is being attacked
     * @return The String representing the damage done to the entity
     */
    String magicMissile(Entity e);

    /* Allows the implementing entity to use the Fireball spell
     * @param e The entity that is being attacked
     * @return The String representing the damage done to the entity
     */
    String fireball(Entity e);

    /* Allows the implementing entity to use the Thunder Clap spell
     * @param e The entity that is being attacked
     * @return The String representing the damage done to the entity
     */
    String thunderclap(Entity e);
}
