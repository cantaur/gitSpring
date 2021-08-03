package sp2.md.service;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sp2.md.filesetting.Path;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Log4j
@Service
public class FileUploadServiceImpl implements FileUploadService{
    @Override
    public String saveStore(MultipartFile file) { //파일이 저장되는 경로를 반환하는 String 타입
        String ofname = file.getOriginalFilename();
        //확장자를 추출하기 위해 뒤에서부터 dot(.)이 맨 처음 나오는걸 찾음
        int idx = ofname.lastIndexOf(".");
        String ofheader = ofname.substring(0,idx); //확장자 제외한 파일의 이름
        String ext = ofname.substring(idx); //확장자
        
        long ms = System.currentTimeMillis(); //현재 시스템 시간 받아오기

        StringBuilder sb = new StringBuilder(); //스트링 저장소
        sb.append(ofheader);
        sb.append("_");
        sb.append(ms);
        sb.append(ext);
        String saveFileName = sb.toString(); 
        //Db에 저장할때는 ofName, save~, filesize 저장하셈

        long fsize = file.getSize(); //파일 용량 구함
        log.info("#ofname: "+ofname);
        log.info("#saveFileName: "+saveFileName);
        log.info("#fsize: "+fsize);

        boolean flag = writeFile(file, saveFileName);
        if(flag){
            log.info("#업로드 성공");
            return ofname;

        }else{
            log.info("#업로드 실패");
        }

        return Path.FILE_STORE + saveFileName; //물리적인 파일 경로가 리턴
    }

    //파일 업로드하는 stream
    public boolean writeFile(MultipartFile file, String saveFileName){ //파일 이름을 그대로 저장하는 경우에는 외부패키지에서 이 메소드를 호출할 수 있음
        File rootDir = new File(Path.FILE_STORE); //저장이 되는 root 디렉토리
        if(!rootDir.exists()){ //temp 디렉토리가 존재하지 않을 때
            rootDir.mkdirs();
        }

        FileOutputStream fos = null;
        try {
            byte data[]=file.getBytes(); //파일을 byte단위로 쪼개는 메소드
            fos = new FileOutputStream(Path.FILE_STORE+saveFileName);
            fos.write(data);
            fos.flush();
            return true;
        } catch (IOException e) {
            return false;
        }finally {
            try {
                if(fos !=null) fos.close();
            }catch (IOException ie){}
        }
    }
}

//오리지널파일 이름에 시간정보 입력
