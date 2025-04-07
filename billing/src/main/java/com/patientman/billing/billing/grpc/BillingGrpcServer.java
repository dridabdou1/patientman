package com.patientman.billing.billing.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc.BillingServiceImplBase;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService
public class BillingGrpcServer extends BillingServiceImplBase {

    @Override
    public void createBillingAccount(BillingRequest request, StreamObserver<BillingResponse> responseObserver) {        
        log.info("CreateBillingAccount {}", request.toString());

        // super.createBillingAccount(request, responseObserver);

        BillingResponse response = BillingResponse.newBuilder()
                .setAccountId("1")
                .setStatus("ACTIVE")                
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

