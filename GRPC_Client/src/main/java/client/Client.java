package client;

import com.konstantinos.User.LoginRequest;
import com.konstantinos.User.Response;
import com.konstantinos.userGrpc;
import com.konstantinos.userGrpc.userBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {

	public static void main(String[] args) {
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
		
		userBlockingStub userStub = userGrpc.newBlockingStub(channel);
		
		LoginRequest loginrequest = LoginRequest.newBuilder().setUsername("Kostas").setPassword("Kostas").build();
		
		Response response = userStub.login(loginrequest);
				
		System.out.println("Resp: " + response.getResponsecode() + ", Message: " + response.getResponsemessage());
	}

}
