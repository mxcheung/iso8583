package com.maxcheung.puzzle.util.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.maxcheung.puzzle.service.SequenceCalculatorService;
import com.maxcheung.puzzle.service.SequenceCalculatorServiceImpl;


@RunWith(value = Parameterized.class)
public class SequenceCalculatorServiceParametrizedTest {
	SequenceCalculatorService sequenceCalculatorService;
	final int cores = Runtime.getRuntime().availableProcessors();

	private int nElements;
	private int precedingElementsC;
	private String expected;

	// parameters pass via this constructor
	public SequenceCalculatorServiceParametrizedTest(int nElements, int precedingElementsC, String expected) {
		this.nElements = nElements;
		this.precedingElementsC = precedingElementsC;
		this.expected = expected;
	}

	// Declares parameters here
	@Parameters(name = "{index}: sequenceCalculatorService..({0},{1})={2}")
	public static Iterable<Object[]> data1() {
		return Arrays.asList(new Object[][] { { 5, 2, "21" }, 
				{ 100, 10, "513946235090696089113" }, 
				{ 1_000_000, 200, "4876116127317978755731357827750324258198152034112500967562513636619100036936684812989451641586872711144897223910945432996565260927444970434341751181069846806035413935036849768233333056995297839546987556514137209634510462520098420637699122339150135182336136343710133666277873058791705786865172269505137348053072138083039879594822827363049313266638167969278996668128689537007027256375312439259756963378414674923338559662872664630830473868844780514858035026724948605282302145282924362435477685770948854908568552575590262317036471687656087729795369566602222613158544956594630758919558839490389685877537107146938624305312410352805240021534303354075104449242854817709239419566186643324364485619839724438068872130809826576025107299021708751358587712196989115611745764936650199174040410120012977020177891702305788835974404793078619886693921589490810020682287541450768124222593617753502950448413400068069839575506281609611700039096644528048520573952064700692432979185292498572446344530804462471767505921755829674711688765439056157222401212017883032535501314332340039385928056085145060700217900637020812413411308610121928026123701441848386741142775717387490509972541107994804323593105039052556442336528920420940313" },

		});
	}

	@Test
	public void shouldCalculatePrecedingSum() {

		BigInteger total = null;

		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(cores);
		sequenceCalculatorService = new SequenceCalculatorServiceImpl(executor);
		try {
			total = sequenceCalculatorService.calculateSequence(cores, nElements, precedingElementsC);
			sequenceCalculatorService.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Shouldn't have thrown an exception!");
		}

		assertEquals(new BigInteger(expected), total);
	}
}
