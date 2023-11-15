package com.ebp.in.serviceimpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebp.in.entity.Connection;
import com.ebp.in.entity.Reading;
import com.ebp.in.exception.NoSuchCustomerException;
import com.ebp.in.repository.ConnectionRepository;
import com.ebp.in.repository.ReadingRepository;
import com.ebp.in.service.BillService;
import com.ebp.in.service.ReadingService;



@Service
public class ReadingServiceImpl implements ReadingService {

	@Autowired
	private ReadingRepository readingRepository;

	@Autowired
	private BillService billService;
	
	@Autowired
	private ConnectionRepository connectionRepository;
	
	/*
	 * We are generating the reading
	 */
	@Override
	public Reading selfSubmit(Reading reading) {
		Double pricePerUnit = reading.getPricePerUnits();
<<<<<<< HEAD
		Reading reading1 ;
		Connection existingConnection = connectionRepository.findById(reading.getConnectionId()).get();
=======
		Reading reading1 = null;
		Connection existingConnection = reading.getReadingForConnection();
>>>>>>> b423192b85408e1fe090b5a59aa16a47da93172b
		Long connectionId = existingConnection.getConnectionId();
		if (connectionId == 0) {
			reading.setPricePerUnits(pricePerUnit);
			reading.setReadingDate(new Date());
			reading.setReadingPhoto("Photo");
			reading1 = readingRepository.save(reading);
			
		} else {
			reading.setReadingForConnection(existingConnection);
			reading.setPricePerUnits(pricePerUnit);
			reading.setReadingDate(new Date());
			reading.setReadingPhoto("Photo");
			reading1 = readingRepository.save(reading);
			
		}

		return reading1;
	}

	/*
	 * We are searching the meter reading by taking the consumer number,
	 * If consumer number does not exists throws No such customer exception
	 */
	@Override
	public Reading findMeterReadingByConsumerNumber(Long consumerNumber) throws NoSuchCustomerException {
		return readingRepository.readMeterReadingByConsumerNumber(consumerNumber)
				.orElseThrow(() -> new NoSuchCustomerException("Customer Not Exist!"));
	}

}
