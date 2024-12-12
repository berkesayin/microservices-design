package dev.berke.app.slot;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SlotService {

    private final SlotRepository slotRepository;
    private final SlotMapper slotMapper;


    @CachePut(value = "slots", key = "#result")
    public Integer createSlot(SlotRequest slotRequest) {
        var slot = slotMapper.toSlot(slotRequest);
        return slotRepository.save(slot).getId();
    }

    @Cacheable(value = "slots", key = "#slotId")
    public SlotResponse getSlotById(Integer slotId) {
        return slotRepository.findById(slotId)
                .map(slotMapper::toSlotResponse)
                .orElseThrow(() -> new EntityNotFoundException("Slot not found with the ID:: " + slotId));
    }

    @Cacheable(value = "slots")
    public List<SlotResponse> getAllSlots() {
        return slotRepository.findAll()
                .stream()
                .map(slotMapper::toSlotResponse)
                .collect(Collectors.toList());
    }

}
