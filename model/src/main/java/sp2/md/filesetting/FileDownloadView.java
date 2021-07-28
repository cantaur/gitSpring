package sp2.md.filesetting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.log4j.Log4j;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Log4j
public class FileDownloadView extends AbstractView { //View(jsp) 역할을 하는 class (jdk 1.8), servlet.xml에 등록해야함
    public FileDownloadView() {
        setContentType("application/download;charset=utf-8");

    }
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {

        File file = (File)model.get("downloadFile"); //컨트롤러의 download파일이 넘어오게 되어있음

        response.setContentType(getContentType());
        response.setContentLength((int)file.length()); //파일 객체의 길이
        String value = "attachment; filename="+java.net.URLEncoder.encode(file.getName(), "utf-8") + ";"; //브라우저에 넘겨주는 헤더 정보
        response.setHeader("Content-Disposition", value); //http 프로토콜에 정의된 데이터 전달 공간==header
        response.setHeader("Content-Transfer-Encoding", "binary"); //2진파일이다


        OutputStream os = response.getOutputStream(); //사용자의 브라우저와 연결된 객체
        FileInputStream fis = null;	 //요청이 들어오면 서버에 있는 파일을 읽어서 클라이언트의 브라우저에 쓴다
        try {
            fis = new FileInputStream(file);
            FileCopyUtils.copy(fis, os);
            os.flush();
        }catch(IOException ie) {
            log.info("#FileDownloadView ie: " + ie);
        }finally {
            if(fis != null) fis.close();
            if(os != null) os.close();
        }
    }

}
