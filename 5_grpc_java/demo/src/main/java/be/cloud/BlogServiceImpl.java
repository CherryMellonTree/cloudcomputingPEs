package be.cloud;

import java.util.ArrayList;

import be.cloud.BlogServiceGrpc.BlogServiceImplBase;

public class BlogServiceImpl extends BlogServiceImplBase{
    private ArrayList<Blogpost> blogpostlist;
    
    /**
     * Add a blogpost
     */
    public void addBlogpost(be.cloud.Blogpost request, io.grpc.stub.StreamObserver<be.cloud.BlogpostAddSuccess> responseObserver) {

        if (blogpostlist == null) {
            blogpostlist = new ArrayList<Blogpost>();
        }
        Blogpost post = Blogpost.newBuilder()
            .setId(request.getId())
            .setAuthor(request.getAuthor())
            .setTitle(request.getTitle())
            .setImportant(request.getImportant())
            .setDescription(request.getDescription())
            .build();

        blogpostlist.add(post);
        
        responseObserver.onNext(BlogpostAddSuccess.newBuilder().setSuccess(true).build());
        responseObserver.onCompleted();                
    }

    /**
     * Get a blogpost using its ID
     */
    public void getBlogpost(be.cloud.BlogpostID request, io.grpc.stub.StreamObserver<be.cloud.Blogpost> responseObserver) {
        Blogpost correct = Blogpost.newBuilder()
            .setId(0)
            .setAuthor("none found")
            .setTitle("none found")
            .setImportant(false)
            .setDescription("none found")
            .build();
        for (Blogpost post : blogpostlist){
            if ( post.getId() == request.getId()){
                correct = post;
            }
        }
        responseObserver.onNext(correct);
        responseObserver.onCompleted();
        }

    /**
     */
    public void addBlogpostComment(be.cloud.BlogpostComment request,io.grpc.stub.StreamObserver<be.cloud.BlogpostCommentAddSuccess> responseObserver) {
        boolean success = false;
        for (Blogpost post : blogpostlist){
            if ( post.getId() == request.getBlogpostID() ){
                Blogpost correct = Blogpost.newBuilder()
                .setId(post.getId())
                .setAuthor(post.getAuthor())
                .setTitle(post.getTitle())
                .setImportant(post.getImportant())
                .setDescription(post.getDescription())
                .addComments(request)
                .build();

                blogpostlist.add(correct);
                success = true;
                blogpostlist.remove(post);
                break;
            }
        }

        responseObserver.onNext(BlogpostCommentAddSuccess.newBuilder().setSuccess(success).build());
        responseObserver.onCompleted();
    }

    /**
     */
    public void getBlogposts(be.cloud.BlogpostListRequest request,
        io.grpc.stub.StreamObserver<be.cloud.BlogpostList> responseObserver) {
            BlogpostList list = BlogpostList.newBuilder().addAllBlogposts(blogpostlist).build();
            responseObserver.onNext(list);
            responseObserver.onCompleted();
        }

    /**
     */
    public void searchBlogposts(be.cloud.BlogpostSearchRequest request,
        io.grpc.stub.StreamObserver<be.cloud.BlogpostSearchResults> responseObserver) {
            BlogpostSearchResults list = BlogpostSearchResults.newBuilder().addAllBlogposts(blogpostlist).build();
            responseObserver.onNext(list);
            responseObserver.onCompleted();
        }

    /**
     */
    public void likeBlogpost(be.cloud.BlogpostID request,
        io.grpc.stub.StreamObserver<be.cloud.BlogpostLikeSuccess> responseObserver) {
            boolean success = false;
            for (Blogpost post : blogpostlist){
                if ( post.getId() == request.getId() ){
                    Blogpost correct = Blogpost.newBuilder()
                    .setId(post.getId())
                    .setAuthor(post.getAuthor())
                    .setTitle(post.getTitle())
                    .setImportant(post.getImportant())
                    .setDescription(post.getDescription())
                    .addComments(BlogpostComment.newBuilder().setBlogpostID(post.getId()).setCid(0).setAuthor("0").setComment("Like").setPositive(true).build())
                    .build();
    
                    blogpostlist.add(correct);
                    success = true;
                    blogpostlist.remove(post);
                    break;
                }
            }
    
            responseObserver.onNext(BlogpostLikeSuccess.newBuilder().setSuccess(success).build());
            responseObserver.onCompleted();
        }
    
}
