import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;

import static net.frogmouth.rnd.heif.libheif.*;


class HeifDemo {
    public void main(String[] args) {
        System.out.println("-- Starting HeifDemo --");
        MemorySegment version = heif_get_version();
        System.out.println(String.format("libheif version: %s", version.getUtf8String(0)));
        if (args.length > 0) {
            String filename = args[0];
            System.out.println(String.format("-- Trying to dump %s --", filename));
            SegmentAllocator allocator = (byteSize, byteAlignment) -> Arena.ofAuto().allocate(byteSize, byteAlignment);
            MemorySegment ctx = heif_context_alloc();
            MemorySegment input_filename = allocator.allocateUtf8String(filename);
            heif_context_read_from_file(allocator, ctx, input_filename, NULL());
            heif_context_debug_dump_boxes_to_file(ctx, 0);
            heif_context_free(ctx);
        }
        System.out.println("-- Ending HeifDemo --");
    }
}
