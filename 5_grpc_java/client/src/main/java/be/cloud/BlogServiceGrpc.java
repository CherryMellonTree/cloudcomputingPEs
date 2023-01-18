package be.cloud;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.0)",
    comments = "Source: blogdb.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BlogServiceGrpc {

  private BlogServiceGrpc() {}

  public static final String SERVICE_NAME = "be.cloud.BlogService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<be.cloud.Blogpost,
      be.cloud.BlogpostAddSuccess> getAddBlogpostMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addBlogpost",
      requestType = be.cloud.Blogpost.class,
      responseType = be.cloud.BlogpostAddSuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<be.cloud.Blogpost,
      be.cloud.BlogpostAddSuccess> getAddBlogpostMethod() {
    io.grpc.MethodDescriptor<be.cloud.Blogpost, be.cloud.BlogpostAddSuccess> getAddBlogpostMethod;
    if ((getAddBlogpostMethod = BlogServiceGrpc.getAddBlogpostMethod) == null) {
      synchronized (BlogServiceGrpc.class) {
        if ((getAddBlogpostMethod = BlogServiceGrpc.getAddBlogpostMethod) == null) {
          BlogServiceGrpc.getAddBlogpostMethod = getAddBlogpostMethod =
              io.grpc.MethodDescriptor.<be.cloud.Blogpost, be.cloud.BlogpostAddSuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addBlogpost"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.cloud.Blogpost.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.cloud.BlogpostAddSuccess.getDefaultInstance()))
              .setSchemaDescriptor(new BlogServiceMethodDescriptorSupplier("addBlogpost"))
              .build();
        }
      }
    }
    return getAddBlogpostMethod;
  }

  private static volatile io.grpc.MethodDescriptor<be.cloud.BlogpostID,
      be.cloud.Blogpost> getGetBlogpostMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getBlogpost",
      requestType = be.cloud.BlogpostID.class,
      responseType = be.cloud.Blogpost.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<be.cloud.BlogpostID,
      be.cloud.Blogpost> getGetBlogpostMethod() {
    io.grpc.MethodDescriptor<be.cloud.BlogpostID, be.cloud.Blogpost> getGetBlogpostMethod;
    if ((getGetBlogpostMethod = BlogServiceGrpc.getGetBlogpostMethod) == null) {
      synchronized (BlogServiceGrpc.class) {
        if ((getGetBlogpostMethod = BlogServiceGrpc.getGetBlogpostMethod) == null) {
          BlogServiceGrpc.getGetBlogpostMethod = getGetBlogpostMethod =
              io.grpc.MethodDescriptor.<be.cloud.BlogpostID, be.cloud.Blogpost>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getBlogpost"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.cloud.BlogpostID.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.cloud.Blogpost.getDefaultInstance()))
              .setSchemaDescriptor(new BlogServiceMethodDescriptorSupplier("getBlogpost"))
              .build();
        }
      }
    }
    return getGetBlogpostMethod;
  }

  private static volatile io.grpc.MethodDescriptor<be.cloud.BlogpostComment,
      be.cloud.BlogpostCommentAddSuccess> getAddBlogpostCommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addBlogpostComment",
      requestType = be.cloud.BlogpostComment.class,
      responseType = be.cloud.BlogpostCommentAddSuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<be.cloud.BlogpostComment,
      be.cloud.BlogpostCommentAddSuccess> getAddBlogpostCommentMethod() {
    io.grpc.MethodDescriptor<be.cloud.BlogpostComment, be.cloud.BlogpostCommentAddSuccess> getAddBlogpostCommentMethod;
    if ((getAddBlogpostCommentMethod = BlogServiceGrpc.getAddBlogpostCommentMethod) == null) {
      synchronized (BlogServiceGrpc.class) {
        if ((getAddBlogpostCommentMethod = BlogServiceGrpc.getAddBlogpostCommentMethod) == null) {
          BlogServiceGrpc.getAddBlogpostCommentMethod = getAddBlogpostCommentMethod =
              io.grpc.MethodDescriptor.<be.cloud.BlogpostComment, be.cloud.BlogpostCommentAddSuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addBlogpostComment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.cloud.BlogpostComment.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.cloud.BlogpostCommentAddSuccess.getDefaultInstance()))
              .setSchemaDescriptor(new BlogServiceMethodDescriptorSupplier("addBlogpostComment"))
              .build();
        }
      }
    }
    return getAddBlogpostCommentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<be.cloud.BlogpostListRequest,
      be.cloud.BlogpostList> getGetBlogpostsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getBlogposts",
      requestType = be.cloud.BlogpostListRequest.class,
      responseType = be.cloud.BlogpostList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<be.cloud.BlogpostListRequest,
      be.cloud.BlogpostList> getGetBlogpostsMethod() {
    io.grpc.MethodDescriptor<be.cloud.BlogpostListRequest, be.cloud.BlogpostList> getGetBlogpostsMethod;
    if ((getGetBlogpostsMethod = BlogServiceGrpc.getGetBlogpostsMethod) == null) {
      synchronized (BlogServiceGrpc.class) {
        if ((getGetBlogpostsMethod = BlogServiceGrpc.getGetBlogpostsMethod) == null) {
          BlogServiceGrpc.getGetBlogpostsMethod = getGetBlogpostsMethod =
              io.grpc.MethodDescriptor.<be.cloud.BlogpostListRequest, be.cloud.BlogpostList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getBlogposts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.cloud.BlogpostListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.cloud.BlogpostList.getDefaultInstance()))
              .setSchemaDescriptor(new BlogServiceMethodDescriptorSupplier("getBlogposts"))
              .build();
        }
      }
    }
    return getGetBlogpostsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<be.cloud.BlogpostSearchRequest,
      be.cloud.BlogpostSearchResults> getSearchBlogpostsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "searchBlogposts",
      requestType = be.cloud.BlogpostSearchRequest.class,
      responseType = be.cloud.BlogpostSearchResults.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<be.cloud.BlogpostSearchRequest,
      be.cloud.BlogpostSearchResults> getSearchBlogpostsMethod() {
    io.grpc.MethodDescriptor<be.cloud.BlogpostSearchRequest, be.cloud.BlogpostSearchResults> getSearchBlogpostsMethod;
    if ((getSearchBlogpostsMethod = BlogServiceGrpc.getSearchBlogpostsMethod) == null) {
      synchronized (BlogServiceGrpc.class) {
        if ((getSearchBlogpostsMethod = BlogServiceGrpc.getSearchBlogpostsMethod) == null) {
          BlogServiceGrpc.getSearchBlogpostsMethod = getSearchBlogpostsMethod =
              io.grpc.MethodDescriptor.<be.cloud.BlogpostSearchRequest, be.cloud.BlogpostSearchResults>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "searchBlogposts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.cloud.BlogpostSearchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.cloud.BlogpostSearchResults.getDefaultInstance()))
              .setSchemaDescriptor(new BlogServiceMethodDescriptorSupplier("searchBlogposts"))
              .build();
        }
      }
    }
    return getSearchBlogpostsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<be.cloud.BlogpostID,
      be.cloud.BlogpostLikeSuccess> getLikeBlogpostMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "likeBlogpost",
      requestType = be.cloud.BlogpostID.class,
      responseType = be.cloud.BlogpostLikeSuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<be.cloud.BlogpostID,
      be.cloud.BlogpostLikeSuccess> getLikeBlogpostMethod() {
    io.grpc.MethodDescriptor<be.cloud.BlogpostID, be.cloud.BlogpostLikeSuccess> getLikeBlogpostMethod;
    if ((getLikeBlogpostMethod = BlogServiceGrpc.getLikeBlogpostMethod) == null) {
      synchronized (BlogServiceGrpc.class) {
        if ((getLikeBlogpostMethod = BlogServiceGrpc.getLikeBlogpostMethod) == null) {
          BlogServiceGrpc.getLikeBlogpostMethod = getLikeBlogpostMethod =
              io.grpc.MethodDescriptor.<be.cloud.BlogpostID, be.cloud.BlogpostLikeSuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "likeBlogpost"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.cloud.BlogpostID.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  be.cloud.BlogpostLikeSuccess.getDefaultInstance()))
              .setSchemaDescriptor(new BlogServiceMethodDescriptorSupplier("likeBlogpost"))
              .build();
        }
      }
    }
    return getLikeBlogpostMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BlogServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BlogServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BlogServiceStub>() {
        @java.lang.Override
        public BlogServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BlogServiceStub(channel, callOptions);
        }
      };
    return BlogServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BlogServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BlogServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BlogServiceBlockingStub>() {
        @java.lang.Override
        public BlogServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BlogServiceBlockingStub(channel, callOptions);
        }
      };
    return BlogServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BlogServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BlogServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BlogServiceFutureStub>() {
        @java.lang.Override
        public BlogServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BlogServiceFutureStub(channel, callOptions);
        }
      };
    return BlogServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class BlogServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void addBlogpost(be.cloud.Blogpost request,
        io.grpc.stub.StreamObserver<be.cloud.BlogpostAddSuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddBlogpostMethod(), responseObserver);
    }

    /**
     */
    public void getBlogpost(be.cloud.BlogpostID request,
        io.grpc.stub.StreamObserver<be.cloud.Blogpost> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBlogpostMethod(), responseObserver);
    }

    /**
     */
    public void addBlogpostComment(be.cloud.BlogpostComment request,
        io.grpc.stub.StreamObserver<be.cloud.BlogpostCommentAddSuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddBlogpostCommentMethod(), responseObserver);
    }

    /**
     */
    public void getBlogposts(be.cloud.BlogpostListRequest request,
        io.grpc.stub.StreamObserver<be.cloud.BlogpostList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBlogpostsMethod(), responseObserver);
    }

    /**
     */
    public void searchBlogposts(be.cloud.BlogpostSearchRequest request,
        io.grpc.stub.StreamObserver<be.cloud.BlogpostSearchResults> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchBlogpostsMethod(), responseObserver);
    }

    /**
     */
    public void likeBlogpost(be.cloud.BlogpostID request,
        io.grpc.stub.StreamObserver<be.cloud.BlogpostLikeSuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLikeBlogpostMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddBlogpostMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                be.cloud.Blogpost,
                be.cloud.BlogpostAddSuccess>(
                  this, METHODID_ADD_BLOGPOST)))
          .addMethod(
            getGetBlogpostMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                be.cloud.BlogpostID,
                be.cloud.Blogpost>(
                  this, METHODID_GET_BLOGPOST)))
          .addMethod(
            getAddBlogpostCommentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                be.cloud.BlogpostComment,
                be.cloud.BlogpostCommentAddSuccess>(
                  this, METHODID_ADD_BLOGPOST_COMMENT)))
          .addMethod(
            getGetBlogpostsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                be.cloud.BlogpostListRequest,
                be.cloud.BlogpostList>(
                  this, METHODID_GET_BLOGPOSTS)))
          .addMethod(
            getSearchBlogpostsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                be.cloud.BlogpostSearchRequest,
                be.cloud.BlogpostSearchResults>(
                  this, METHODID_SEARCH_BLOGPOSTS)))
          .addMethod(
            getLikeBlogpostMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                be.cloud.BlogpostID,
                be.cloud.BlogpostLikeSuccess>(
                  this, METHODID_LIKE_BLOGPOST)))
          .build();
    }
  }

  /**
   */
  public static final class BlogServiceStub extends io.grpc.stub.AbstractAsyncStub<BlogServiceStub> {
    private BlogServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlogServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BlogServiceStub(channel, callOptions);
    }

    /**
     */
    public void addBlogpost(be.cloud.Blogpost request,
        io.grpc.stub.StreamObserver<be.cloud.BlogpostAddSuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddBlogpostMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBlogpost(be.cloud.BlogpostID request,
        io.grpc.stub.StreamObserver<be.cloud.Blogpost> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBlogpostMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addBlogpostComment(be.cloud.BlogpostComment request,
        io.grpc.stub.StreamObserver<be.cloud.BlogpostCommentAddSuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddBlogpostCommentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBlogposts(be.cloud.BlogpostListRequest request,
        io.grpc.stub.StreamObserver<be.cloud.BlogpostList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBlogpostsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void searchBlogposts(be.cloud.BlogpostSearchRequest request,
        io.grpc.stub.StreamObserver<be.cloud.BlogpostSearchResults> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchBlogpostsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void likeBlogpost(be.cloud.BlogpostID request,
        io.grpc.stub.StreamObserver<be.cloud.BlogpostLikeSuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLikeBlogpostMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BlogServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<BlogServiceBlockingStub> {
    private BlogServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlogServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BlogServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public be.cloud.BlogpostAddSuccess addBlogpost(be.cloud.Blogpost request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddBlogpostMethod(), getCallOptions(), request);
    }

    /**
     */
    public be.cloud.Blogpost getBlogpost(be.cloud.BlogpostID request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBlogpostMethod(), getCallOptions(), request);
    }

    /**
     */
    public be.cloud.BlogpostCommentAddSuccess addBlogpostComment(be.cloud.BlogpostComment request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddBlogpostCommentMethod(), getCallOptions(), request);
    }

    /**
     */
    public be.cloud.BlogpostList getBlogposts(be.cloud.BlogpostListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBlogpostsMethod(), getCallOptions(), request);
    }

    /**
     */
    public be.cloud.BlogpostSearchResults searchBlogposts(be.cloud.BlogpostSearchRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchBlogpostsMethod(), getCallOptions(), request);
    }

    /**
     */
    public be.cloud.BlogpostLikeSuccess likeBlogpost(be.cloud.BlogpostID request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLikeBlogpostMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BlogServiceFutureStub extends io.grpc.stub.AbstractFutureStub<BlogServiceFutureStub> {
    private BlogServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BlogServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BlogServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<be.cloud.BlogpostAddSuccess> addBlogpost(
        be.cloud.Blogpost request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddBlogpostMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<be.cloud.Blogpost> getBlogpost(
        be.cloud.BlogpostID request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBlogpostMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<be.cloud.BlogpostCommentAddSuccess> addBlogpostComment(
        be.cloud.BlogpostComment request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddBlogpostCommentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<be.cloud.BlogpostList> getBlogposts(
        be.cloud.BlogpostListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBlogpostsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<be.cloud.BlogpostSearchResults> searchBlogposts(
        be.cloud.BlogpostSearchRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchBlogpostsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<be.cloud.BlogpostLikeSuccess> likeBlogpost(
        be.cloud.BlogpostID request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLikeBlogpostMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_BLOGPOST = 0;
  private static final int METHODID_GET_BLOGPOST = 1;
  private static final int METHODID_ADD_BLOGPOST_COMMENT = 2;
  private static final int METHODID_GET_BLOGPOSTS = 3;
  private static final int METHODID_SEARCH_BLOGPOSTS = 4;
  private static final int METHODID_LIKE_BLOGPOST = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BlogServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BlogServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_BLOGPOST:
          serviceImpl.addBlogpost((be.cloud.Blogpost) request,
              (io.grpc.stub.StreamObserver<be.cloud.BlogpostAddSuccess>) responseObserver);
          break;
        case METHODID_GET_BLOGPOST:
          serviceImpl.getBlogpost((be.cloud.BlogpostID) request,
              (io.grpc.stub.StreamObserver<be.cloud.Blogpost>) responseObserver);
          break;
        case METHODID_ADD_BLOGPOST_COMMENT:
          serviceImpl.addBlogpostComment((be.cloud.BlogpostComment) request,
              (io.grpc.stub.StreamObserver<be.cloud.BlogpostCommentAddSuccess>) responseObserver);
          break;
        case METHODID_GET_BLOGPOSTS:
          serviceImpl.getBlogposts((be.cloud.BlogpostListRequest) request,
              (io.grpc.stub.StreamObserver<be.cloud.BlogpostList>) responseObserver);
          break;
        case METHODID_SEARCH_BLOGPOSTS:
          serviceImpl.searchBlogposts((be.cloud.BlogpostSearchRequest) request,
              (io.grpc.stub.StreamObserver<be.cloud.BlogpostSearchResults>) responseObserver);
          break;
        case METHODID_LIKE_BLOGPOST:
          serviceImpl.likeBlogpost((be.cloud.BlogpostID) request,
              (io.grpc.stub.StreamObserver<be.cloud.BlogpostLikeSuccess>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BlogServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BlogServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return be.cloud.Blogdb.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BlogService");
    }
  }

  private static final class BlogServiceFileDescriptorSupplier
      extends BlogServiceBaseDescriptorSupplier {
    BlogServiceFileDescriptorSupplier() {}
  }

  private static final class BlogServiceMethodDescriptorSupplier
      extends BlogServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BlogServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BlogServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BlogServiceFileDescriptorSupplier())
              .addMethod(getAddBlogpostMethod())
              .addMethod(getGetBlogpostMethod())
              .addMethod(getAddBlogpostCommentMethod())
              .addMethod(getGetBlogpostsMethod())
              .addMethod(getSearchBlogpostsMethod())
              .addMethod(getLikeBlogpostMethod())
              .build();
        }
      }
    }
    return result;
  }
}
