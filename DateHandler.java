package ps.tef.api.handler;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author rudolfoborges
 * @since 7/25/17 3:52 PM
 */
public class DateHandler {

	public static void main(String[] args) {
		final List<Campaign> campaigns = new ArrayList<>();
		init(campaigns);

		final Campaign campaign = new Campaign();
		campaign.init(5);

		final Set<Campaign> updatedItens = new HashSet<>();

		while (true) {
			final List<Campaign> campaignsTargets = campaigns
					.stream()
					.filter(target -> ChronoUnit.DAYS.between(campaign.closedAt, target.closedAt) <= 0)
					.collect(Collectors.toList());

			if (campaignsTargets.isEmpty()) {
				break;
			}

			campaignsTargets
					.stream()
					.sorted(Comparator.comparing(target -> target.closedAt))
					.forEach(target -> {
						target.addDay();
						System.out.println(target);
					});
			updatedItens.addAll(campaignsTargets);

			//System.out.println(campaignsList);
		}

		System.out.println(updatedItens);
	}

	private static void init(List<Campaign> campaigns) {
		IntStream
				.rangeClosed(1, 4)
				.forEach(value -> {
					final Campaign campaign = new Campaign();
					campaign.init(value);
					campaigns.add(campaign);
				});
	}


	public static class Campaign {

		String name;
		LocalDate startedAt;
		LocalDate closedAt;

		public void init(int i) {
			name = String.format("Campaign %d", i);
			if (i == 1 || i == 3 || i == 5) {
				startedAt = LocalDate.of(2017, 10, 1);
				closedAt = LocalDate.of(2017, 10, 3);
			} else if (i == 2 || i == 4) {
				startedAt = LocalDate.of(2017, 10, 1);
				closedAt = LocalDate.of(2017, 10, 2);
			}
		}

		public void addDay() {
			closedAt = closedAt.plusDays(1);
		}

		@Override
		public String toString() {
			final StringBuilder builder = new StringBuilder()//
					.append("Campaign [")//
					.append("name=\"")//
					.append(name).append("\"")//
					.append(",startedAt=")//
					.append(startedAt)//
					.append(",closedAt=")//
					.append(closedAt)//
					.append("]");
			return builder.toString();
		}

	}

	public static class ReferenceDate {
		LocalDate closedAt;
	}

}
