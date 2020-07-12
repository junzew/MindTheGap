package ca.ubc.cs.cpsc210.mindthegap.TfL;

import ca.ubc.cs.cpsc210.mindthegap.model.Line;
import ca.ubc.cs.cpsc210.mindthegap.model.Station;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

/**
 * Wrapper for TfL Arrival Data Provider
 */
public class TfLHttpArrivalDataProvider extends AbstractHttpDataProvider {
    private Station stn;

    public TfLHttpArrivalDataProvider(Station stn) {
        super();
        this.stn = stn;
    }

    @Override
    /**
     * Produces URL used to query TfL web service for expected arrivals at
     * station specified in call to constructor.
     *
     * @returns URL to query TfL web service for arrival data
     */
    protected URL getURL() throws MalformedURLException {
        String request = "";

        // TODO Phase 2 Task 7
        String stnID = stn.getID();
        String lineString = "";
        Set<Line> lines = stn.getLines();
        for (Line l : lines) {
            lineString += l.getId() + ",";
        }
        request = "https://api.tfl.gov.uk/Line/"+ lineString + "/Arrivals?stopPointId="+ stnID +"&app_id=&app_key=";

        return new URL(request);
    }
}
