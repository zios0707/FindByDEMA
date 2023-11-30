package com.findbydema;

import com.findbydema.domain.livechat.entity.ChatRecord;
import com.findbydema.domain.livechat.repository.RecordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FIndByDemaApplicationTests {

	@Autowired
	private RecordRepository recordRepository;

	@Test
	void test() {
		ChatRecord record = new ChatRecord("1", "1", "Hello World!");
		ChatRecord record1 = new ChatRecord("1", "2", "Hello World!");
		ChatRecord record2 = new ChatRecord("1", "3", "Hello World!");
		ChatRecord record3 = new ChatRecord("1", "4", "Hello World!");
		ChatRecord record4 = new ChatRecord("2", "5", "Hello World!");

		recordRepository.save(record);
		recordRepository.save(record1);
		recordRepository.save(record2);
		recordRepository.save(record3);
		recordRepository.save(record4);

		List<ChatRecord> list = recordRepository.findAllByRoomId("1");
		System.out.println(list.toString());

		for (ChatRecord rec: list) {
			System.out.print(rec.getRoomId());
			System.out.print(" / ");
			System.out.print(rec.getWriterSid());
			System.out.print(" / ");
			System.out.println(rec.getContent());
		}

		System.out.println(recordRepository.count());

		recordRepository.delete(record4);
	}

}
