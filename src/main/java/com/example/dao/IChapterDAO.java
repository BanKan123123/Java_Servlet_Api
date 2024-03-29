package com.example.dao;

import com.example.model.BookModel;
import com.example.model.ChapterModel;

import java.util.List;

public interface IChapterDAO extends GenericDAO<ChapterModel>{

    List<ChapterModel> findAllChapter();

    ChapterModel findOneChapter(int id);

    Long addChapter (ChapterModel chapterModel);

    void updateChapter (ChapterModel chapterModel, int id);

    void deleteChapter (int id);



}
