package com.A1.task3.reader;

import com.A1.task3.entity.Entities;
import com.A1.task3.entity.Entity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Readable {

    List readFile(String filename) throws IOException;
}
