import { Polygon } from "./geometry/polygon";

export class InterruptSchedule {
  id: number;
  startHour: number;
  endHour: number;
  sectorName: string;
  sectorPolygon: Polygon;
}