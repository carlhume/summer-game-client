package com.tds.game;

import org.glassfish.jersey.logging.LoggingFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.MediaType;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MapLoader {

    private static final Logger logger = Logger.getLogger( MapLoader.class.getName() );

    private Client client;

    public MapLoader() {
        client = createWebClient();
    }

    public GameMap loadMap( int id ) {
        // TODO: Configure instead of hardcode ...
        WebTarget webTarget = client.target("http://localhost:8080/load-map" ).queryParam( "id", id );
        Invocation.Builder invocationBuilder = webTarget.request( MediaType.APPLICATION_JSON );
        return invocationBuilder.get( GameMap.class );
    }

    private Client createWebClient() {
        Feature loggingFeature = new LoggingFeature( logger, Level.INFO, null, null );
        return ClientBuilder.newBuilder()
                            .register( loggingFeature )
                            .build();
    }

}
