package soo.md.service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.*;

public interface DragdropService {
    Map<String, List<Object>> getUpdateFileName();

    MultipartHttpServletRequest getMultipartRequest(); //겟메소드
    void setMultipartRequest(MultipartHttpServletRequest multipartRequest); //셋메소드
}
