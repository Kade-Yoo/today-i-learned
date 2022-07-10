package chapter.one.part.one;

import java.io.File;
import java.io.FileFilter;

/**
 * 1.3.1 메서드와 람다를 일급 시민으로 예제
 */
public class MethodReference {

    /**
     * 숨겨진 파일 목록 조회
     *
     * @param isAfterJava8 java8 이후 버전 여부
     * @return 숨겨진 파일 목록
     */
    public File[] getHiddenFiles(boolean isAfterJava8) {
        if (isAfterJava8) {
            return new File(".").listFiles(isHiddenAfterJava8());
        }

        return new File(".").listFiles(isHiddenBeforeJava8());
    }

    /**
     * Java 8 이후 메소드 참조 없을 때 숨겨진 파일 Filter
     *
     * @return 숨겨진 파일 필터
     */
    private FileFilter isHiddenAfterJava8() {
        return File::isHidden;
    }

    /**
     * Java 8 이전 메소드 참조 없을 때 숨겨진 파일 Filter
     *
     * @return 숨겨진 파일 필터
     */
    private FileFilter isHiddenBeforeJava8() {
        return new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        };
    }
}
