package forum.global.service;

import java.util.ArrayList;
import java.util.List;

import forum.global.domain.Releasehomework;

public interface ReleasehomeworkService {
	int addReleasehomework(Releasehomework artical);
	boolean delReleasehomework(int id);
	boolean updateReleasehomework(Releasehomework artical);
	Releasehomework getReleasehomeworkById(int id);
	ArrayList<Releasehomework> getAllReleasehomework();
	Releasehomework getReleasehomeworkByTitle(String title);

}
