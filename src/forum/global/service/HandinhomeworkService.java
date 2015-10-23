package forum.global.service;

import java.util.ArrayList;

import forum.global.domain.Handinhomework;

public interface HandinhomeworkService {
	int addHandinhomework(Handinhomework handinhomework);
	int delHandinhomework(int handinhomework);
	int updateHandinhomework(Handinhomework handinhomework);
	Handinhomework getHandinhomeworkById(String idString);
	ArrayList<Handinhomework> getAllHandinhomework();
}
