# Demo for Java 21+ use of libheif - using jextract

## Overview

This demonstrates how to use [libheif](https://github.com/strukturag/libheif) in Java 21 or later.

It relies on the [jextract](https://github.com/openjdk/jextract) tool and the [Foreign Function and
Memory API](https://openjdk.org/jeps/442). It won't work with earlier versions of Java.

## Setup

1. Start with Linux
1. Install Java 21
1. Clone this repo
1. Extract or link the jextract tool into the repo checkout. Use the [pre-built binaries](https://jdk.java.net/jextract/)
1. Clone [libheif](https://github.com/strukturag/libheif) into the repo checkout.

At this point you should have a directory tree that looks like this

```
.
├── build.sh
├── heifdemo.java
├── jextract-21
│   ├── bin
│   │   ├── ....
│   ├── conf
│   │   ├── ....
│   ├── include
│   │   ├── ....
│   ├── legal
│   │   ├── ....
│   ├── lib
│   │   ├── ....
│   └── release
├── libheif
│   ├── appveyor.yml
│   ├── build-emscripten.sh
│   ├── cmake
│   │   └── ....
│   ├── CMakeLists.txt
│   ├── CMakePresets.json
│   ├── COPYING
│   ├── CPPLINT.cfg
│   ├── examples
│   │   ├── ....
│   ├── extra
│   │   ├── ....
│   ├── fuzzing
│   │   ├── ....
│   ├── gdk-pixbuf
│   │   ├── ...
│   ├── gnome
│   │   ├── ....
│   ├── go
│   │   └── ....
│   ├── libheif
│   │   ├── ....
│   ├── libheif.pc.in
│   ├── logos
│   │   └── ....
│   ├── post.js
│   ├── README.md
│   ├── scripts
│   │   ├── ....
│   ├── tests
│   │   ├── ....
│   └── third-party
│       ├── ....
├── libheif.dump
├── README.md
└── run.sh
```

## Build

1. Build libheif. See libheif/README.md in your tree for more instructions

1. Run build.sh. The results of that should look like this:
```
WARNING: A restricted method in java.lang.foreign.AddressLayout has been called
WARNING: java.lang.foreign.AddressLayout::withTargetLayout has been called by module org.openjdk.jextract
WARNING: Use --enable-native-access=org.openjdk.jextract to avoid a warning for this module

WARNING: skipping .__clang_max_align_nonce2 because of unsupported type usage: long double
Note: Some input files use preview features of Java SE 21.
Note: Recompile with -Xlint:preview for details.
```

1. Run run.sh with some sample file. 

```
bash ./run.sh libheif/examples/example.heic
```

The results of that should look like:

```
Note: heifdemo.java uses preview features of Java SE 21.
Note: Recompile with -Xlint:preview for details.
-- Starting HeifDemo --
libheif version: 1.17.6
-- Trying to dump libheif/examples/example.heic --
Box: ftyp -----
size: 28   (header size: 8)
major brand: mif1
minor version: 0
compatible brands: mif1,heic,hevc

Box: meta -----
size: 921   (header size: 12)
| Box: hdlr -----
| size: 33   (header size: 12)
| pre_defined: 0
| handler_type: pict
| name: 
| 
| Box: pitm -----
| size: 14   (header size: 12)
| item_ID: 20004
| 
| Box: iloc -----
| size: 88   (header size: 12)
| item ID: 20004
|   construction method: 0
|   data_reference_index: 0
|   base_offset: 957
|   extents: 0,333704 
| item ID: 20005
|   construction method: 0
|   data_reference_index: 0
|   base_offset: 334669
|   extents: 0,24523 
| item ID: 20006
|   construction method: 0
|   data_reference_index: 0
|   base_offset: 359200
|   extents: 0,330132 
| item ID: 20007
|   construction method: 0
|   data_reference_index: 0
|   base_offset: 689340
|   extents: 0,28758 
| 
| Box: iinf -----
| size: 140   (header size: 12)
| | Box: infe -----
| | size: 31   (header size: 12)
| | item_ID: 20004
| | item_protection_index: 0
| | item_type: hvc1
| | item_name: HEVC Image
| | content_type: 
| | content_encoding: 
| | item uri type: 
| | hidden item: false
| | 
| | Box: infe -----
| | size: 31   (header size: 12)
| | item_ID: 20005
| | item_protection_index: 0
| | item_type: hvc1
| | item_name: HEVC Image
| | content_type: 
| | content_encoding: 
| | item uri type: 
| | hidden item: false
| | 
| | Box: infe -----
| | size: 31   (header size: 12)
| | item_ID: 20006
| | item_protection_index: 0
| | item_type: hvc1
| | item_name: HEVC Image
| | content_type: 
| | content_encoding: 
| | item uri type: 
| | hidden item: false
| | 
| | Box: infe -----
| | size: 31   (header size: 12)
| | item_ID: 20007
| | item_protection_index: 0
| | item_type: hvc1
| | item_name: HEVC Image
| | content_type: 
| | content_encoding: 
| | item uri type: 
| | hidden item: false
| 
| Box: iref -----
| size: 40   (header size: 12)
| reference with type 'thmb' from ID: 20005 to IDs: 20004 
| reference with type 'thmb' from ID: 20007 to IDs: 20006 
| 
| Box: iprp -----
| size: 594   (header size: 8)
| | Box: ipco -----
| | size: 550   (header size: 8)
| | | Box: hvcC -----
| | | size: 126   (header size: 8)
| | | configuration_version: 1
| | | general_profile_space: 0
| | | general_tier_flag: 0
| | | general_profile_idc: 1
| | | general_profile_compatibility_flags: 0110.0000 0000.0000 0000.0000 0000.0000 
| | | general_constraint_indicator_flags: 10010000 00000000 00000000 00000000 00000000 00000000 
| | | general_level_idc: 120
| | | min_spatial_segmentation_idc: 0
| | | parallelism_type: 0
| | | chroma_format: 4:2:0
| | | bit_depth_luma: 8
| | | bit_depth_chroma: 8
| | | avg_frame_rate: 0
| | | constant_frame_rate: 0
| | | num_temporal_layers: 1
| | | temporal_id_nested: 1
| | | length_size: 4
| | | <array>
| | | | array_completeness: 0
| | | | NAL_unit_type: 32
| | | | 40 01 0c 01 ff ff 01 60 00 00 03 00 90 00 00 03 00 00 03 00 78 99 8a 02 40 
| | | <array>
| | | | array_completeness: 0
| | | | NAL_unit_type: 33
| | | | 42 01 01 01 60 00 00 03 00 90 00 00 03 00 00 03 00 78 a0 02 80 80 35 9f 59 66 62 a4 91 26 bf fc 1a b0 1a ac 04 00 00 03 00 04 00 00 03 00 64 20 
| | | <array>
| | | | array_completeness: 0
| | | | NAL_unit_type: 34
| | | | 44 01 c1 72 b6 62 40 
| | | 
| | | Box: ispe -----
| | | size: 20   (header size: 12)
| | | image width: 1280
| | | image height: 854
| | | 
| | | Box: hvcC -----
| | | size: 125   (header size: 8)
| | | configuration_version: 1
| | | general_profile_space: 0
| | | general_tier_flag: 0
| | | general_profile_idc: 1
| | | general_profile_compatibility_flags: 0110.0000 0000.0000 0000.0000 0000.0000 
| | | general_constraint_indicator_flags: 10010000 00000000 00000000 00000000 00000000 00000000 
| | | general_level_idc: 60
| | | min_spatial_segmentation_idc: 0
| | | parallelism_type: 0
| | | chroma_format: 4:2:0
| | | bit_depth_luma: 8
| | | bit_depth_chroma: 8
| | | avg_frame_rate: 0
| | | constant_frame_rate: 0
| | | num_temporal_layers: 1
| | | temporal_id_nested: 1
| | | length_size: 4
| | | <array>
| | | | array_completeness: 0
| | | | NAL_unit_type: 32
| | | | 40 01 0c 01 ff ff 01 60 00 00 03 00 90 00 00 03 00 00 03 00 3c 99 8a 02 40 
| | | <array>
| | | | array_completeness: 0
| | | | NAL_unit_type: 33
| | | | 42 01 01 01 60 00 00 03 00 90 00 00 03 00 00 03 00 3c a0 0a 08 0d 9f 79 66 62 a4 91 26 bf fc 1a 80 1a ac 04 00 00 03 00 04 00 00 03 00 64 20 
| | | <array>
| | | | array_completeness: 0
| | | | NAL_unit_type: 34
| | | | 44 01 c1 72 b6 62 40 
| | | 
| | | Box: ispe -----
| | | size: 20   (header size: 12)
| | | image width: 320
| | | image height: 212
| | | 
| | | Box: hvcC -----
| | | size: 126   (header size: 8)
| | | configuration_version: 1
| | | general_profile_space: 0
| | | general_tier_flag: 0
| | | general_profile_idc: 1
| | | general_profile_compatibility_flags: 0110.0000 0000.0000 0000.0000 0000.0000 
| | | general_constraint_indicator_flags: 10010000 00000000 00000000 00000000 00000000 00000000 
| | | general_level_idc: 120
| | | min_spatial_segmentation_idc: 0
| | | parallelism_type: 0
| | | chroma_format: 4:2:0
| | | bit_depth_luma: 8
| | | bit_depth_chroma: 8
| | | avg_frame_rate: 0
| | | constant_frame_rate: 0
| | | num_temporal_layers: 1
| | | temporal_id_nested: 1
| | | length_size: 4
| | | <array>
| | | | array_completeness: 0
| | | | NAL_unit_type: 32
| | | | 40 01 0c 01 ff ff 01 60 00 00 03 00 90 00 00 03 00 00 03 00 78 99 8a 02 40 
| | | <array>
| | | | array_completeness: 0
| | | | NAL_unit_type: 33
| | | | 42 01 01 01 60 00 00 03 00 90 00 00 03 00 00 03 00 78 a0 02 80 80 35 9f 59 66 62 a4 91 26 bf fc 1a b0 1a ac 04 00 00 03 00 04 00 00 03 00 64 20 
| | | <array>
| | | | array_completeness: 0
| | | | NAL_unit_type: 34
| | | | 44 01 c1 72 b6 62 40 
| | | 
| | | Box: hvcC -----
| | | size: 125   (header size: 8)
| | | configuration_version: 1
| | | general_profile_space: 0
| | | general_tier_flag: 0
| | | general_profile_idc: 1
| | | general_profile_compatibility_flags: 0110.0000 0000.0000 0000.0000 0000.0000 
| | | general_constraint_indicator_flags: 10010000 00000000 00000000 00000000 00000000 00000000 
| | | general_level_idc: 60
| | | min_spatial_segmentation_idc: 0
| | | parallelism_type: 0
| | | chroma_format: 4:2:0
| | | bit_depth_luma: 8
| | | bit_depth_chroma: 8
| | | avg_frame_rate: 0
| | | constant_frame_rate: 0
| | | num_temporal_layers: 1
| | | temporal_id_nested: 1
| | | length_size: 4
| | | <array>
| | | | array_completeness: 0
| | | | NAL_unit_type: 32
| | | | 40 01 0c 01 ff ff 01 60 00 00 03 00 90 00 00 03 00 00 03 00 3c 99 8a 02 40 
| | | <array>
| | | | array_completeness: 0
| | | | NAL_unit_type: 33
| | | | 42 01 01 01 60 00 00 03 00 90 00 00 03 00 00 03 00 3c a0 0a 08 0d 9f 79 66 62 a4 91 26 bf fc 1a 80 1a ac 04 00 00 03 00 04 00 00 03 00 64 20 
| | | <array>
| | | | array_completeness: 0
| | | | NAL_unit_type: 34
| | | | 44 01 c1 72 b6 62 40 
| | 
| | Box: ipma -----
| | size: 36   (header size: 12)
| | associations for item ID: 20004
| | | property index: 1 (essential: true)
| | | property index: 2 (essential: false)
| | associations for item ID: 20005
| | | property index: 3 (essential: true)
| | | property index: 4 (essential: false)
| | associations for item ID: 20006
| | | property index: 5 (essential: true)
| | | property index: 2 (essential: false)
| | associations for item ID: 20007
| | | property index: 6 (essential: true)
| | | property index: 4 (essential: false)

Box: mdat -----
size: 333712   (header size: 8)

Box: mdat -----
size: 24531   (header size: 8)

Box: mdat -----
size: 330140   (header size: 8)

Box: mdat -----
size: 28766   (header size: 8)

Box: mdat -----
size: 16   (header size: 8)
-- Ending HeifDemo --
```

If any of that does not work, consult the jextract documentation, and update the scripts as needed.

## License

This code is covered by the same [license as libheif](https://github.com/strukturag/libheif/blob/master/COPYING).
The `heifdemo.java` content is considered sample code.

## Support

Only under commercial agreement. 
