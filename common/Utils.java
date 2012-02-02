package org.agetac.common;

import org.osmdroid.api.IGeoPoint;

public class Utils {

	private static final int EARTH_RADIUS_METERS = 6378137;

	/**
	 * Retourne la distance en mètre entre deux coordonnées GPS
	 * 
	 * @param src
	 *            une coordonnée GPS au format IGeoPoint
	 * @param dest
	 *            une coordonnée GPS au format IGeoPoint
	 * @return la distance en mètre entre ces deux coordonées
	 */
	public static double getDistanceInMeter(IGeoPoint src, IGeoPoint dest) {
		double distance = 0;
		
        // premier point
        double srcLat = src.getLatitudeE6()*(1E-6);
        double srcLong = src.getLongitudeE6()*(1E-6);
        // deuxieme point
        double destLat = dest.getLatitudeE6()*(1E-6);
        double destLong = dest.getLongitudeE6()*(1E-6);

        // calcul des angles en radians
        double rlo1 = Math.toRadians(srcLong);
        double rla1 = Math.toRadians(srcLat);
        double rlo2 = Math.toRadians(destLong);
        double rla2 = Math.toRadians(destLat);

        double dlo = (rlo2 - rlo1) / 2;
        double dla = (rla2 - rla1) / 2;

        double angle = (Math.sin(dla) * Math.sin(dla)) + Math.cos(rla1)
                * Math.cos(rla2) * (Math.sin(dlo) * Math.sin(dlo));

        distance = EARTH_RADIUS_METERS
                * (2 * Math.atan2(Math.sqrt(angle), Math
                        .sqrt(1 - angle)));
		
		return distance;
	}
}
