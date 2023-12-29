# ./jextract-21/bin/jextract --dump-includes libheif.dump ~/libheif/libheif/heif.h

CWD=$(pwd)
LIBHEIF_DIR="$CWD/libheif"
LIBHEIF_BUILD_DIR="$LIBHEIF_DIR/build"

./jextract-21/bin/jextract \
    --target-package net.frogmouth.rnd.heif \
    --source \
    --header-class-name libheif \
    --library "$LIBHEIF_BUILD_DIR/libheif/libheif.so" \
    @libheif.dump \
    "$LIBHEIF_DIR/libheif/heif.h"

./jextract-21/bin/javac --enable-preview --source=21 net/frogmouth/rnd/heif/*.java
