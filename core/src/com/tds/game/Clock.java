package com.tds.game;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Clock {

    private static final Logger logger = Logger.getLogger( Clock.class.getName() );

    public long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public void waitFor( long miliseconds ) {
        logger.log(Level.FINE, "Clock asked to wait for " + miliseconds + " at " + getCurrentTime() );
        synchronized ( this ) {
            try {
                wait(miliseconds);
            } catch (InterruptedException e) {
                logger.log(Level.FINEST, "Clock wait interrupted", e);
            }
        }
        logger.log( Level.FINE, "Clock finished wait for " + miliseconds + " at " + getCurrentTime() );
    }
}
