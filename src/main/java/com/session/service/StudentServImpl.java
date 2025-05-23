package com.session.service;

import com.session.StudentRequest;
import com.session.StudentResponse;
import com.session.StudentServiceGrpc;
import com.session.entity.Student;
import com.session.repo.StudentRepo;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class StudentServImpl extends StudentServiceGrpc.StudentServiceImplBase {
    private final StudentRepo studentRepo;

    @Override
    public void createStudent(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        Student student = Student.builder()
                .name(request.getName())
                .email(request.getEmail())
                .build();

        student = studentRepo.save(student);

        StudentResponse response = StudentResponse.newBuilder()
                .setId(student.getId())
                .setName(student.getName())
                .setEmail(student.getEmail())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
