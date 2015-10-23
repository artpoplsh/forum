package forum.global.dao;
import java.util.ArrayList;
import java.util.List;

import forum.global.domain.*;
public interface ReleasehomeworkDao {
	int addReleasehomework(Releasehomework artical);
	boolean delReleasehomework(int id);
	boolean updateReleasehomework(Releasehomework artical);
	Releasehomework getReleasehomeworkById(int id);
	ArrayList<Releasehomework> getAllReleasehomework();
	Releasehomework getReleasehomeworkByTitle(String title);

}
