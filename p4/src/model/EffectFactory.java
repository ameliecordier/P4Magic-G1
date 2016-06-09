/**
 * MagicP4
 * IUT Lyon 1 - 2016
 */
package model;

import java.util.Random;

/**
 * Class EffectFactory
 *
 * @author hakkahi - IUT Lyon 1 - 2016
 *
 */
public class EffectFactory {

    /**
     * Returns a random effect chosen amongst the available effects listed
     *
     * @return an effect
     */
    public static Effect createEffect() {
        int min = 0;
        int max = 0;
        Random rand = new Random();
        //Tire un nombre aléatoire entre min et max compris
        int random = rand.nextInt(max - min + 1) + min;

        switch (random) {

            case 0:
                return new ChangeColorEffect();
            //case 1:
            //    return new DisappearEffect();
        }

        return null;

    }
    
}
