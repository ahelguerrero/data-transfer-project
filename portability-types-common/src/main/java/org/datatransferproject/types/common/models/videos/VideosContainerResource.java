/*
 * Copyright 2019 The Data Transfer Project Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.datatransferproject.types.common.models.videos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import org.datatransferproject.types.common.models.ContainerResource;

public class VideosContainerResource extends ContainerResource {
  private static final String VIDEOS_COUNT_DATA_NAME = "videosCount";
  private static final String ALBUMS_COUNT_DATA_NAME = "albumsCount";

  private final Collection<VideoAlbum> albums;
  private final Collection<VideoObject> videos;

  @JsonCreator
  public VideosContainerResource(
      @JsonProperty("albums") Collection<VideoAlbum> albums,
      @JsonProperty("videos") Collection<VideoObject> videos) {
    this.albums = albums == null ? ImmutableList.of() : albums;
    this.videos = videos == null ? ImmutableList.of() : videos;
  }

  public Collection<VideoAlbum> getAlbums() {
    return albums;
  }

  public Collection<VideoObject> getVideos() {
    return videos;
  }

  @Override
  public Map<String, Integer> getCounts() {
    return new ImmutableMap.Builder<String, Integer>()
        .put(VIDEOS_COUNT_DATA_NAME, videos.size())
        .put(ALBUMS_COUNT_DATA_NAME, albums.size())
        .build();
  }
}
