package user;

import com.konstantinos.demo.User.Empty;
import com.konstantinos.demo.User.LoginRequest;
import com.konstantinos.demo.User.Response;
import com.konstantinos.demo.userGrpc.userImplBase;

import io.grpc.ServerServiceDefinition;
import io.grpc.stub.StreamObserver;;

public class UserService extends userImplBase {

	@Override
	public ServerServiceDefinition bindService() {
		// TODO Auto-generated method stub
		return super.bindService();
	}

	@Override
	public void login(LoginRequest request, StreamObserver<Response> responseObserver) {
		System.out.println("Inside login");
		
		Response.Builder resp = Response.newBuilder();
		
		String username = request.getUsername();
		String password = request.getPassword();
		
		if(username.equals(password)) 
		{
			resp.setResponsecode(0).setResponsemessage("Success");
		}else 
		{
			resp.setResponsecode(1001).setResponsemessage("Failure..user doesn't exist");
		}
		
		responseObserver.onNext(resp.build());
		responseObserver.onCompleted();
		
	}

	@Override
	public void logout(Empty request, StreamObserver<Response> responseObserver) {
		System.out.println("Inside logout");
		
	}	

}
