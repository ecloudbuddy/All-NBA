package com.gmail.jorgegilcavazos.ballislife.data;

import com.gmail.jorgegilcavazos.ballislife.features.model.Highlight;

import java.util.List;

import io.reactivex.Single;

public interface HighlightsRepository {

    void reset();

    Single<List<Highlight>> next();
}
