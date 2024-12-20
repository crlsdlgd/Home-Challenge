package com.kruger.utils;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Polygon;

public class PolygonUtils {
	public static Polygon createPolygon(double[][] coordinates) {
        GeometryFactory geometryFactory = new GeometryFactory();

        // Convertir las coordenadas a un array de `Coordinate`
        Coordinate[] coords = new Coordinate[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            coords[i] = new Coordinate(coordinates[i][0], coordinates[i][1]);
        }

        // Crear el polígono (debe ser cerrado, es decir, el último punto igual al primero)
        LinearRing shell = geometryFactory.createLinearRing(coords);
        return geometryFactory.createPolygon(shell, null);
    }
}
