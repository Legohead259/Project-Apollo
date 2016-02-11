package objectVariables;

import objects.Railgun;

/**
 * Variables 
 * @author 667161
 *
 */
public class ProjectileVariables {
	/**
	 * Mass for ATI's projectile
	 */
	protected double mass;
	
	/**
	 * Contact surface area for ATI's projectile
	 */
	protected double contactSA; 
	
	/**
	 * Air pressure behind ATI's projectile
	 */
	protected double pressure;
	
	/**
	 * The length of ATI's projectile
	 */
	protected double length; 
	
	/**
	 * The width of ATI's projectile
	 */
	protected double width;
	
	/**
	 * The height of ATI's projectile
	 */
	protected double height; 
	
	/**
	 * The density of the ATI's projectile's material
	 */
	protected double density;
	
	/**
	 * The volume of ATI's projectile
	 */
	protected double volume;
	
	/**
	 * The muzzle velocity of ATI's projectile
	 */
	protected double muzzleVelocity; 
	
	/**
	 * The acceleration of ATI's projectile
	 */
	protected double acceleration;
	
	/**
	 * The final velocity of ATI's projectile
	 */
	protected double finalVelo;
	
	/**
	 * The time it takes ATI's projectile to travel through the barrel
	 */
	protected double barrelTravelTime; 
	
	/**
	 * The force ATI's projectile impacts with
	 */
	protected double force;
	
	/**
	 * The muzzle energy that ATI's projectile exits the barrel with
	 */
	protected double muzzleEnergy;
	
	/**
	 * The railgun that will shoot ATI's projectile
	 */
	protected Railgun railgun;
	
	/**
	 * The initial velocity of ATI's projectile
	 */
	protected final double initVelo = 0;
}
