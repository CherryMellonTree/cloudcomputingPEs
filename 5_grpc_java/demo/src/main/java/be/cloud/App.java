package be.cloud;

import io.grpc.Server;
import io.grpc.ServerBuilder;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Server server = ServerBuilder.forPort(8080).addService(new BlogServiceImpl()).build();
        try{
            server.start();
            server.awaitTermination();
        }catch(Exception e){
            System.out.println("error error error lol");
            System.out.println(e);
        }
    }
}
