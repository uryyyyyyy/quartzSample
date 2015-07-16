package com.example.util.jobs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class WriteTextJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("job job");
        List<String> list = new ArrayList<>();
        list.add("message");

        try (BufferedWriter out = Files.newBufferedWriter(new File("./mm.txt").toPath(), StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            list.stream().forEach(v -> writeOut(out, v));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeOut(BufferedWriter out, String str) {
        try {
            out.write(str);
            out.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
