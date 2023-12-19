
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.Random;

    public class RandomCountry {
        @PersistenceContext
        private EntityManager entityManager;

        public RandomCountry(EntityManager entityManager) {
            this.entityManager = entityManager;
        }
        public Country getRandomCountry() {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
            Root<Country> root = countQuery.from(Country.class);

            countQuery.select(criteriaBuilder.count(root));
            Long count = entityManager.createQuery(countQuery).getSingleResult();

            Random random = new Random();
            int randomIndex = random.nextInt(count.intValue());

            CriteriaQuery<Country> dataQuery = criteriaBuilder.createQuery(Country.class);
            Root<Country> dataRoot = dataQuery.from(Country.class);

            TypedQuery<Country> typedQuery = entityManager.createQuery(dataQuery.select(dataRoot));
            typedQuery.setFirstResult(randomIndex);
            typedQuery.setMaxResults(1);

            return typedQuery.getSingleResult();
        }

    }


