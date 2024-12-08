package dev.berke.app.slot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SlotService {

    private final SlotRepository slotRepository;
    private final SlotMapper slotMapper;

    public Integer createSlot(SlotRequest slotRequest) {
        var slot = slotMapper.toSlot(slotRequest);
        return slotRepository.save(slot).getId();
    }
}
