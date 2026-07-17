using UnityEngine;
using System.Collections;
using JetBrains.Annotations;
public class Block : MonoBehaviour
{
    private Manager manager;
    public enum BlockType
    {
        Normal,
        Falling,
        Bounce,
        Kill,
        Trip,
        Win
    }
    
    [SerializeField] private BlockType type;

    [Header("Trip")]
    public float tripAngle = 90f;
    public float tripSpeed = .5f;
    public float tripLength = 2f;
    public float tripGrace = 0f;
    private Vector3 startPosition;
    private Quaternion startRotation;
    private Rigidbody rb;
    private bool activated = false;
    private bool inGrace = false;

    [Header("Bounce")]
    public float bounceForce;

    [Header("other (aura) (67)")]
    public GameObject player;

    [Header("Falling")]
    public float fallSpeed;
    public float fallDistance;
    public float cooldown;
    private Renderer platformRenderer;
    private Collider platformCollider;
    private Color initialColor;
    
     void Start()
    {
        manager = FindAnyObjectByType<Manager>();
        startPosition = transform.position;
        startRotation = transform.rotation;
        rb = GetComponent<Rigidbody>();
        platformRenderer = GetComponent<MeshRenderer>();
        platformCollider = GetComponent<Collider>();

        if (platformRenderer != null)
        {
            initialColor = platformRenderer.material.color;
        }
    } 

    void OnCollisionEnter(Collision c)
    {
        if (activated || inGrace) return;

        switch (type)
        {
            case BlockType.Normal:
            break;

            case BlockType.Falling:
            StartCoroutine(Falling());
            break;

            case BlockType.Bounce:
            Bounce(c.gameObject);
            break;

            case BlockType.Kill:
            Kill(c.gameObject);
            break;

            case BlockType.Trip:
            StartCoroutine(Trip());
            break;

            case BlockType.Win:
            if (manager != null)
            {
            manager.StopTimer();
            }
            break;
        }
    }

    IEnumerator Trip()
    {
        activated = true;
        
        Quaternion normalRotation = startRotation;
        Quaternion tripRotation = startRotation * Quaternion.Euler(tripAngle, 0, 0);

        float i = 0;
        while(i < 1)
        {
            i += Time.deltaTime * tripSpeed;
            transform.rotation = Quaternion.Lerp(normalRotation, tripRotation, i);
            yield return null;
        }

        yield return new WaitForSeconds(tripLength);

        i = 0;
        while(i < 1)
        {
            i += Time.deltaTime * tripSpeed;
            transform.rotation = Quaternion.Lerp(tripRotation, normalRotation, i);
            yield return null;
        }
        transform.rotation = normalRotation;
        
        activated = false; 
        inGrace = true; 

        yield return new WaitForSeconds(tripGrace);
        
        inGrace = false; 
    }

    void Bounce(GameObject player)
    {
        Rigidbody playerRb = player.GetComponent<Rigidbody>();
        if(playerRb != null)
        {
            playerRb.linearVelocity = new Vector3(
                playerRb.linearVelocity.x,
                bounceForce,
                playerRb.linearVelocity.z
            );
        }
    }

    IEnumerator Falling()
    {
        activated = true;
        float i = 0;
        Vector3 pointB = new Vector3(startPosition.x, startPosition.y - fallDistance, startPosition.z);

        //dropping
        while(i < 1)
        {
            i += Time.deltaTime * fallSpeed;
            transform.position = Vector3.Lerp(startPosition, pointB, i);

            if (platformCollider != null && i > 0.5)
            {
            platformCollider.enabled = false;
            } 

            if (platformRenderer != null)
            {
                float newAlpha = Mathf.Lerp(initialColor.a, 0f, i);
                Color fadeColor = new Color(initialColor.r, initialColor.g, initialColor.b, newAlpha);
            
                platformRenderer.material.SetColor("_BaseColor", fadeColor);
                platformRenderer.material.SetColor("_Color", fadeColor);
            }

            yield return null;
        }

        yield return new WaitForSeconds(cooldown);

        //going up now
        i = 0;
        while(i < 1)
        {
            i += Time.deltaTime * fallSpeed;
            transform.position = Vector3.Lerp(pointB, startPosition, i);

            if (platformRenderer != null)
            {
                float newAlpha = Mathf.Lerp(0f, initialColor.a, i);
                Color fadeInColor = new Color(initialColor.r, initialColor.g, initialColor.b, newAlpha);
            
                platformRenderer.material.SetColor("_BaseColor", fadeInColor);
                platformRenderer.material.SetColor("_Color", fadeInColor);
            }
            
            yield return null;
        }
        transform.position = startPosition;

        if (platformCollider != null)
        {
            platformCollider.enabled = true;
        }   
        
        activated = false;
        
    }

    static void Kill(GameObject player)
    {
        PlayerScript playerScript = player.GetComponent<PlayerScript>();
        if(playerScript != null)
        {
            playerScript.Die();
        }
    }
}


