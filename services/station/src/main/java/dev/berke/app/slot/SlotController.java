package dev.berke.app.slot;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/slots")
@RequiredArgsConstructor
public class SlotController {

    private final SlotService slotService;

    @PostMapping
    public ResponseEntity<Integer> createSlot(@RequestBody @Valid SlotRequest slotRequest) {
        return ResponseEntity.ok(slotService.createSlot(slotRequest));
    }

    @GetMapping("/{slot-id}")
    public ResponseEntity<SlotResponse> getSlotById(
            @PathVariable("slot-id") Integer slotId
    ) {
        return ResponseEntity.ok(slotService.getSlotById(slotId));
    }

    @GetMapping
    public ResponseEntity<List<SlotResponse>> getAllSlots() {
        return ResponseEntity.ok(slotService.getAllSlots());
    }

}
