package be.cloud;

import be.cloud.BlogServiceGrpc.BlogServiceBlockingStub;
import be.cloud.BlogServiceGrpc.BlogServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();
        BlogServiceBlockingStub stub = BlogServiceGrpc.newBlockingStub(channel);
        System.out.println("test");
        BlogpostAddSuccess value = stub.addBlogpost(Blogpost.newBuilder()
        .setId(1)
        .setAuthor("potato")
        .setTitle("fries")
        .setImportant(true)
        .setDescription("they're just fried potatoes").build());
        value = stub.addBlogpost(Blogpost.newBuilder()
        .setId(2)
        .setAuthor("rice")
        .setTitle("The superior alternative to fries")
        .setImportant(true)
        .setDescription("Sushi should be enough of a justification here").build());
        BlogpostCommentAddSuccess commented = stub.addBlogpostComment(BlogpostComment.newBuilder().setBlogpostID(1).setAuthor("rice").setCid(1).setPositive(false).setComment("Blasphemy, this is an outright lie!").build());
        BlogpostLikeSuccess liked = stub.likeBlogpost(BlogpostID.newBuilder().setId(2).build());
        BlogpostList blogpostlist = stub.getBlogposts(BlogpostListRequest.newBuilder().build());
        System.out.println("All of the blogposts");
        System.out.println(blogpostlist);
        Blogpost singlePost = stub.getBlogpost(BlogpostID.newBuilder().setId(2).build());
        System.out.println("A single blogpost:");
        System.out.println(singlePost);
        channel.shutdown();
    }
}
