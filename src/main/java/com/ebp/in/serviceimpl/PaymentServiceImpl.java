package com.ebp.in.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebp.in.entity.Bill;
import com.ebp.in.entity.Payment;
import com.ebp.in.enums.PaymentStatus;
import com.ebp.in.exception.NoSuchCustomerException;
import com.ebp.in.repository.BillRepository;
import com.ebp.in.repository.PaymentRepository;
import com.ebp.in.service.PaymentService;



@Service

public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private BillRepository billRepository;

	/*
	 * We can view and pay the bill that is generated by choosing the payment mode
	 */
	@Override
	public PaymentStatus payBill(Payment payment) {
		Long billId = payment.getBillPayment().getBillId();
		System.out.println("Bill ID:" + billId);
		Optional<Bill> bill = billRepository.findById(billId);
		//the status of the payment will be shown
		payment.setStatus(PaymentStatus.SUCCESS);   
		payment.setPaymentDate(new Date());
		payment.setLatePaymentCharges(payment.getLatePaymentCharges());
		payment.setTotalPaid(payment.getTotalPaid());
		Payment savedPayment = paymentRepository.save(payment);
		return savedPayment.getStatus();
	}

	/*
	 * Sending email after completion of payment by taking consumerId and email
	 */
	@Override
	public void sendEmailOnPaymentCompletion(Long consumerId, String email) {
		System.out.println("Payment was succufully");

	}

	/*
	 * We can view historical payment by taking the consumer number,
	 * If the consumerNumber does not exists  throws no such customer exception
	 */
	@Override
	public List<Payment> viewHistoricalPayment(Long consumerNumber) throws NoSuchCustomerException {
		List<Payment> payment = paymentRepository.readHistoricalPaymentByConsumerNumber(consumerNumber);
		if (payment == null) {
			throw new NoSuchCustomerException("Reading is not available for this consumer number" + consumerNumber);
		} else {
			return payment;
		}
	}
}