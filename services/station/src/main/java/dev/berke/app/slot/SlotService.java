package dev.berke.app.slot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SlotService {

    private final SlotRepository slotRepository;
}
