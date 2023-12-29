java \
   --enable-native-access=ALL-UNNAMED \
   --enable-preview --source=21 \
   -Djava.library.path=/home/bradh/libheif/build/libheif \
   heifdemo.java \
   "$@"
